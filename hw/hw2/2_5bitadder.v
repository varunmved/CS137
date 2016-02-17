// Adder.v, 137 Verilog Programming Assignment #2
// Adding Number, 5 bits maximum
// PUT YOUR NAME HERE
module TestMod;                     // the "main" thing
   parameter STDIN = 32'h8000_0000; // I/O address of keyboard input channel

   reg [7:0] str [1:3]; // typing in 2 chars at a time (decimal # and Enter key)
   reg [4:0] X, Y;      // 5-bit X, Y to sum
   wire [4:0] S;        // 5-bit Sum to see as result
   wire C5;             // like to know this as well from result of Adder

   instantiate the big adder module (giving X and Y as input, getting S and C5 as output)

   initial begin
      prompt for X: $display("Enter X: ");
      get 1st character:        --> str[1] = $fgetc(STDIN);
      get 2nd character:        --> str[2] = $fgetc(STDIN);
      and the ENTER key:        --> ...
      convert str[1] (times 10) and str[2] (times 1) as X

      do the same for y

      #1; // wait until Adder gets them processed
      $display what X and Y were entered (run demo to see format)
      $display what S and C5 are (run demo to see format)
   end
endmodule

module BigAdder(X, Y, S, C5);
   input [4:0] X, Y;   // two 5-bit input items
   output ...          // S should be similar
   output ...          // another output for a different size

   ...                 // declare temporary wires

   ... (get an instance of a full adder, C0 is hardcoded 0)
   ... (get another instance of a full adder)
   ... (get another instance of a full adder)
   ... (get another instance of a full adder)
   ... (get another instance of a full adder)
endmodule

module FullAdderMod(...); // single-bit adder module
   ... code that full adder here ...
   ...
   ...
endmodule
