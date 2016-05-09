// main.v
//Varun Ved

`include "CU.v"        // will include modules in CU.v when compiled
`include "modules.v"   // will include modules in modules.v when compiled

module ClockMod(clk);  // clock signal generator
   output clk;
   reg clk;

   initial #144 $finish;

   initial begin
      #2;
      forever begin
         #1;
         clk = 0;
         #1;
         clk = 1;
      end
   end
endmodule

module main();
   wire [15:0] addr, inst, BusOut, ARout, IRout;
   wire Iout;                                     // "I" bit 15 of instruction
   wire Read, inrPC, ldAR, ldIR, ldI, x2, x5, x7; // control signals
   wire [0:15] T;                                 // CU's sequencer, debug use

   PCmod myPC(inrPC, addr);
   MEMmod myMEM(Read, ARout[11:0], inst);  // MEM addr is last 12 bits from AR
   ARorIRmod myAR(BusOut, ldAR, ARout);
   ARorIRmod myIR(BusOut, ldIR, IRout);
   Imod myI(BusOut, ldI, Iout);
   BusMod myBus(addr, IRout, inst, x2, x5, x7, BusOut); // bus, also a module

   ClockMod myClk(clk);
   CUmod myCU(clk, IRout[14:12], Iout, inrPC, Read, ldAR, ldIR, ldI, x2, x5, x7, T);

   initial begin
$display("                                          i");
$display("                                       I  n  R  l  l");
$display("      c                                o  r  e  d  d  l");
$display("      l   PC   MEM   Bus   AR    IR    u  P  a  A  I  d  x  x  x");
$display("time  k  addr  inst  out   out   out   t  C  d  R  R  I  2  5  7  T0~15");
$display("----  -  ----  ----  ----  ----  ----  -  -  -  -  -  -  -  -  -  ---------------");
$monitor("%4d  %b  %x  %x  %x  %x  %x  %b  %b  %b  %b  %b  %b  %b  %b  %b  %b", 
$time, clk, addr, inst, BusOut, ARout, IRout, Iout, inrPC, Read, ldAR, ldIR, ldI, x2, x5, x7, T);
   end
endmodule

