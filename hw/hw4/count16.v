//varun ved
//Ripple carry counter:
module ripple_carry_counter(q, clk, reset);
output [3:0] q;
input clk, reset;
T_FF tff0(q[0], clk, reset);
T_FF tff1(q[1], q[0], reset);
T_FF tff2(q[2], q[1], reset);
T_FF tff3(q[3], q[2], reset);
endmodule 

//T flip-flop: 
module T_FF(q, clk, reset);
output q;
input clk, reset;
wire d;
D_FF dff0(q, d, clk, reset);
not n1(d, q); // not is Verilog-provided primitive. Case sensitive.
endmodule 

//D flip-flop: 
module D_FF(q, d, clk, reset);
output q;
input d, clk, reset;
reg q; 
always @(posedge reset or negedge clk)
if (reset)
q = 1'b0;
else
q = d;
endmodule


module TestMod;
   reg CLK;
   reg reset;
    wire Q0, Q1, Q2, Q3, C1, C0;

   always begin // this is clock wave
      CLK = 0;  // 0 for half cycle (#1)
      #1;
      CLK = 1;  // 1 for half cycle (#1)
      #1;
   end

   RippleMod my_ripple(Q,CLK,reset)
   //CoderMod my_coder(... arguments ...)

   initial #16 $finish;

   initial begin
      $display("... header ...");
      $monitor("... items ...", ...);
   end
endmodule
