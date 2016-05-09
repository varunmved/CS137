// modules.v
//
// MEMmod
// PCmod
// Imod
// ARorIRmod
// BusMod

module MEMmod(Read, addr, output_buffer);
   ...
   initial $readmemb("instructions.txt", MEM);
endmodule

module PCmod(incr, Q);
   input incr;          // enable upcount
   output [15:0] Q;     // 16-bit output
   reg [15:0] Q;

   initial Q = 0;
   always @(posedge incr) Q = Q + 1; // simulated counting
endmodule

module Imod (what_on_bus, ldI, Iout);  // "I" is Indirect (leftmost bit in instruction)
   ...
endmodule

module ARorIRmod (what_on_bus, ld, storage);  // for both AR and IR
   ...
endmodule

module BusMod(addr, IRout, data, x2, x5, x7, BusOut);
   ...
endmodule

