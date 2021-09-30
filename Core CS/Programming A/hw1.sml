fun is_older (d1 : (int * int * int), d2 : (int * int * int)) =
    if d1 = d2
    then false
    else if (#1 d1) < (#1 d2)
    then true
    else if (#2 d1) < (#2 d2)
    then true
    else if (#3 d1) < (#3 d2)
    then true
    else false

	     
fun number_in_month (dl : (int * int * int) list, m : int) =
    if null dl
    then 0
    else
	if #2 (hd dl) = m
	then 1 + number_in_month (tl dl, m)
	else number_in_month (tl dl, m)

			     
fun number_in_months (dl : (int * int * int) list, m : int list) =
    if null dl
    then 0
    else
	if null m
	then 0
	else
	    number_in_month(dl, hd m) + number_in_months(dl, tl m)

		     
fun dates_in_month (dl : (int * int * int) list, m : int) =
    if null dl
    then []
    else
	if #2 (hd dl) = m
	then (hd dl) :: dates_in_month(tl dl, m)
	else dates_in_month(tl dl, m)

			   
fun dates_in_months (dl : (int * int * int) list, m : int list) =
    if null dl
    then []
    else
	dates_in_month(dl, hd m) @ dates_in_months(dl, tl m)


fun get_nth (s : string list, n : int) =
    if n = 1
    then hd s
    else
	get_nth(tl s, n - 1)

val months = ["January","February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
fun date_to_string (date : (int * int * int)) =
    get_nth(months, #2 date) ^ " " ^ Int.toString(#3 date) ^ ", " ^ Int.toString(#1 date)  


fun number_before_reaching_sum (sum : int, values : int list) =
    let
        fun iterate_sum (i : int, sum_stop : int, max : int, v : int list) =
            if sum_stop + hd v >= max
            then i - 1
            else iterate_sum (i + 1, sum_stop + hd v, max, tl v)
    in 
        iterate_sum (1, 0, sum, values)
    end

val month_days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
fun what_month (day : int) =
    1 + number_before_reaching_sum(day, month_days)

fun month_range (day1 : int, day2 : int) =
    if day1 > day2
    then []
    else 
        let fun month (start_day: int, finish : int) =
            if start_day = finish
            then [what_month(finish)]
            else what_month(start_day) :: month(start_day + 1, finish)
        in
            month(day1, day2)
        end

	
    
fun oldest (dates: (int * int * int) list) =
    if null dates
    then NONE
    else
        let fun old (dates : (int * int * int) list) =
                if null (tl dates)
                then hd dates
                else
                    let
                        val last = old (tl dates)
                        val first = hd dates
                    in
                        if is_older (first, last)
                        then first
                        else last
                    end
        in
            SOME (old dates)
        end
		
    
fun number_in_months_challenge (dl : (int * int * int) list, m : int list) =
    if null dl
    then 0
    else
	let fun duplicates (m: int list) =
		if null (tl m)
		then [hd m]
		else
		    if hd m = hd (tl m)
		    then [hd m] @ duplicates(tl (tl m))
		    else
			[hd m] @ duplicates(tl m)
			   
	in
	    number_in_months (dl, duplicates(m))
	end
		    

fun dates_in_months_challenge (dl : (int * int * int) list, m : int list) =
    if null dl
    then []
    else
	let fun duplicates (m: int list) =
		if null (tl m)
		then [hd m]
		else
		    if hd m = hd (tl m)
		    then [hd m] @ duplicates(tl (tl m))
		    else
			[hd m] @ duplicates(tl m)
			   
	in
	    dates_in_months (dl, duplicates(m))
	end

		 
	     

			    
    
	     


