# University of Washington, Programming Languages, Homework 6, hw6runner.rb

# This is the only file you turn in, so do not modify the other files as
# part of your solution.

class MyPiece < Piece
  # The constant All_My_Pieces should be declared here
  All_My_Pieces = All_Pieces + 
                  [rotations([[0, 0], [-1, 0], [1, 0], [0, -1], [-1, -1]]), # T fat
                  [[[0, 0], [-1, 0], [1, 0], [2, 0], [3, 0]], # more long (only needs two)
                  [[0, 0], [0, -1], [0, 1], [0, 2], [0, 3]]],
                  rotations([[0,0], [1,0], [0,1]])] # V

  Cheat_Piece = [[[0, 0]]] # just one square box

  # your enhancements here
  # class method to choose the next piece
  def self.next_piece (board)
    MyPiece.new(All_My_Pieces.sample, board)
  end

  # class methos to chosse the next piece like cheat piece
  def self.next_cheat_piece(board)
    MyPiece.new(Cheat_Piece, board)
  end

end

class MyBoard < Board
  # your enhancements here

  def initialize (game)
    @grid = Array.new(num_rows) {Array.new(num_columns)}
    @current_block = MyPiece.next_piece(self)
    @score = 0
    @game = game
    @delay = 500
    @cheat = false
  end

  # rotates the current piece 180 degrees
  def rotate_180_degrees
    if !game_over? and @game.is_running?
      @current_block.move(0, 0, -2)
    end
    draw
  end

  # apply the cheat
  def init_cheat
    if !@cheat and @score >= 100
      @cheat = true
      @score -= 100
    end
  end

  # gets next piece
  def next_piece
    if @cheat
      @current_block = MyPiece.next_cheat_piece(self)
      @cheat = false
    else
      @current_block = MyPiece.next_piece(self)
    end

    @current_pos = nil
  end

  # gets the information from the current piece about where it is and uses this
  # to store the piece on the board itself.  Then calls remove_filled.
  def store_current
    locations = @current_block.current_rotation
    displacement = @current_block.position
    (0..(locations.size - 1)).each{|index| 
      current = locations[index];
      @grid[current[1]+displacement[1]][current[0]+displacement[0]] = 
      @current_pos[index]
    }
    remove_filled
    @delay = [@delay - 2, 80].max
  end

end

class MyTetris < Tetris
  # your enhancements here

  # creates a canvas and the board that interacts with it
  def set_board
    @canvas = TetrisCanvas.new
    @board = MyBoard.new(self)
    @canvas.place(@board.block_size * @board.num_rows + 3,
                @board.block_size * @board.num_columns + 6, 24, 80)
    @board.draw
  end

  def key_bindings
      super
      @root.bind('u', proc {@board.rotate_180_degrees}) # key u rotate 180 degrees
      @root.bind('c', proc {@board.init_cheat}) # key c apply cheat
  end

  def buttons
      super
      rotate_one = TetrisButton.new('U', 'lightgreen'){@board.rotate_180}
      rotate_one.place(35, 50, 27, 501)

      cheat_btn = TetrisButton.new('C', 'lightgreen'){@board.init_cheat}
      cheat_btn.place(35, 50, 127, 571)
  end 
 
end


