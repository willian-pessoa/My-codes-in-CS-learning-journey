(* Dan Grossman, Coursera PL, HW2 Provided Code *)

(* if you use this function to compare two strings (returns true if the same
   string), then you avoid several of the functions in problem 1 having
   polymorphic types that may be confusing *)
fun same_string(s1 : string, s2 : string) =
    s1 = s2

(* put your solutions for problem 1 here *)

fun all_except_option (s, sl) =
    case sl of
	[] => NONE
      | x::xs => case same_string(s, x) of
		     true => SOME(xs)
		    |false => case all_except_option(s, xs) of
				  NONE => NONE
				| SOME x2 => SOME(x::x2)
	
fun get_substitutions1 (substitutions, s) =
    case substitutions of
	[] => []
      | (x::xs) => case all_except_option(s, x) of
		       NONE => get_substitutions1(xs, s)
		     | SOME(ys) => ys @ get_substitutions1(xs, s)

fun get_substitutions2 (substitutions, s) =
    let fun aux(subs, s, acc) =
    case subs of
      [] => acc
    | (x::xs) => case all_except_option(s, x) of 
                       NONE => aux(xs, s, acc)
                     | SOME(ys) =>  aux(xs, s, acc @ ys)
    in
	aux(substitutions, s, [])
    end

fun similar_names (subs, {first=first, middle=middle, last=last}) =
    let
	val first_names = first :: get_substitutions2(subs, first)
	fun helper (first_in_list) =
	    case first_in_list of
		[] => []
	      | x::xs => {first=x, middle=middle, last=last} :: helper(xs)
    in
	helper(first_names)
    end
	   
						 
(* you may assume that Num is always used with values 2, 3, ..., 10
   though it will not really come up *)
datatype suit = Clubs | Diamonds | Hearts | Spades
datatype rank = Jack | Queen | King | Ace | Num of int 
type card = suit * rank

datatype color = Red | Black
datatype move = Discard of card | Draw 

exception IllegalMove

(* put your solutions for problem 2 here *)

fun card_color card =
    case card of
	(Diamonds, _) => Red
      | (Hearts, _) => Red
      | (Clubs, _) => Black
      | (Spades, _) => Black
			  

			 
fun card_value (suit, rank) =
    case rank of
	Ace => 11
      | Num x => x
      | _ => 10

fun remove_card (cs, c, e) =
    case cs of
	[] => raise e
      | x::xs => case c = x of
		     true => xs
		   | false => case remove_card(xs, c, e) of
				  [] => [x]
				| y::ys  => x::y::ys
						      
fun all_same_color (cards) =
    case cards of
	[] => true
	   | x::[] => true 
	   | x::y::ys => case card_color(x) = card_color(y) of
			     true => all_same_color(y::ys)
			   | false => false

fun sum_cards (cards) =
    let
	fun sum (cards, total) =
	    case cards of
		[] => total
	      | x::xs => sum(xs, total + card_value(x))
    in
	sum(cards,0)
    end

fun score (cards, goal) =
    let
	val sum = sum_cards(cards)
	val preliminary_score = if sum > goal
			then 3 * (sum - goal)
			else goal - sum
	val same_color = all_same_color(cards)
    in
	if same_color then preliminary_score div 2 else preliminary_score
    end

exception IllegalMove
	      
fun officiate (cards, moves, goal) =
    let
	fun process_moves(cards, moves, held) =
	    case moves of
		[] => held
	      | m::ms => case m of
			     Discard card => process_moves(cards, ms, remove_card(held, card, IllegalMove))
			   | Draw => case cards of
					 [] => held
				       | c::_ => case sum_cards(c::held) > goal of
						     true => c::held
						   | false => process_moves(remove_card(cards, c, IllegalMove), ms, c::held)
    in
	score(process_moves(cards, moves, []), goal)
    end
	
		     
	
