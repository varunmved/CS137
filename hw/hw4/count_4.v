// complete this code first
// then expand it to count 0~15, and name it as count16.v
// use only arrays for all registers and wires (except CLK)
// YOUR NAME HERE

module TestMod;
   reg CLK;
   wire Q0, Q1, Q2, Q3, C1, C0;

   always begin // this is clock wave
      CLK = 0;  // 0 for half cycle (#1)
      #1;
      CLk = 1;  // 1 for half cycle (#1)
      #1;
   end

   RippleMod my_ripple(... arguments ...)
   CoderMod my_coder(... arguments ...)

   initial #16 $finish;

   initial begin
      $display("... header ...");
      $monitor("... items ...", ...);
   end
endmodule

module CoderMod(4 unary input and 2 binary output);
   input are these
   output are these
   logic gate statement to define an output from input
   logic gate statement to define an output from input
endmodule

module RippleMod(CLK, Q0, Q1, Q2, Q3);
   input CLK;
   output Q0, Q1, Q2, Q3;

   reg Q0, Q1, Q2, Q3;

   always @(posedge CLK) begin
      Q0 <= Q3;
      Q1 <= Q0;
      Q2 <= Q1;
      Q3 <= Q2;
   end

   initial begin // here we conveniently set flipflops to 1000 (binary)
      Q0 = 1;
      Q1 = 0;
      Q2 = 0;
      Q3 = 0;
   end
endmodule

