// Adder.v, 5-Bit Adder
// Adding Numbers, sum x and y (each two-decimal digit)
// PUT YOUR NAME HERE

module TestMod;                     // the "main" thing
   parameter STDIN = 32'h8000_0000; // keyboard input

   reg [7:0] str [1:3]; // type in 3 chars (two decimal digits and Enter key)
   reg [4:0] X, Y;      // 5-bit X, Y
   wire C5;             // overall carry
   wire [4:0] S;        // 5-bit Sum

   reg C0;
   wire E;

   AdderMod myAdder(X, Y, C0, S, C5, E);

   initial begin
      $display("Enter X (two digit 00~15 (since max is 01111): ");
      str[1] = $fgetc(STDIN); // ASCII # of 1st digit
      str[2] = $fgetc(STDIN); // ASCII # of 2nd digit
      str[3] = $fgetc(STDIN); // ENTER key
      X = (str[1] - 48) * 10 + str[2] - 48;

      $display("Enter Y (two digit 00~15 (since max is 01111): ");
      str[1] = $fgetc(STDIN); // ASCII # of 1st digit
      str[2] = $fgetc(STDIN); // ASCII # of 2nd digit
      str[3] = $fgetc(STDIN); // ENTER key
      Y = (str[1] - 48) * 10 + str[2] - 48;

     $display("Add or Subtract ( + or - ): ");
      if ($fgetc(STDIN) == "+") 
         C0 = 0;
      else
         C0 = 1;
 
      #1; // wait until add/sub done

      $display("X =%d (%b)  Y =%d (%b)", X, X, Y, Y);
      $display("Result =%d (%b)  C5 = %b", S, S, C5, E);
   end
endmodule

module AdderMod(X, Y, C0, S, C5, E);
   input [4:0] X, Y;
   output [4:0] S;
   output C5;

   wire C1, C2, C3, C4;      // addtional carry-out wires

   wire XOR0, XOR1, XOR2, XOR3, XOR4;

   xor(XOR0, Y[0], C0);
   xor(XOR1, Y[1], C0);
   xor(XOR2, Y[2], C0);
   xor(XOR3, Y[3], C0);
   xor(XOR4, Y[4], C0);


   FullAdderMod FA0( X[0], XOR0,  0, S[0], C1 ); // C0 is 0
   FullAdderMod FA1( X[1], XOR1, C1, S[1], C2 );
   FullAdderMod FA2( X[2], XOR2, C2, S[2], C3 );
   FullAdderMod FA3( X[3], XOR3, C3, S[3], C4 );
   FullAdderMod FA4( X[4], XOR4, C4, S[4], C5 ); // C5 (overflow)
    
   xor(E,C5,C4);

endmodule

module FullAdderMod(X, Y, Cin, S, Cout); // single-bit adder
   input X, Y, Cin;          // X Y and Carry-in bits
   output S, Cout;           // Sum and Carry-out bits

   wire and0, and1, xor0;    // additional wires

   and(and0, X, Y);
   and(and1, xor0, Cin);
   or(Cout, and0, and1);     // Carry-out bit

   xor(xor0, X, Y);
   xor(S, Cin, xor0);        // Sum bit
endmodule


