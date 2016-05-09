// CU.v
// Control Unit with its Sequencer, Decoder, Signal Definer

// given clk, IR (3-bit opcode), Iout, CUmod outputs 8 control signals
module CUmod (clk, IR3, Iout, inrPC, Read, ldAR, ldIR, ldI, x2, x5, x7, T);
   ...
   wire clrSC; // internal signal
// clocking unary signals T0, T1, T2, ...
   ...
// from 3 bits of IR[14:12], map to unary D0, D1, D2, ..., D7
   ...
// define 9 signals using T, D, Iout as input
   ...
endmodule

// carry out signal definitions (paper HW #1)
module SignalDefinerMod(T, D, Iout, inrPC, Read, ldAR, ldIR, ldI, x2, x5, x7, clrSC);
   ...
   //   Fetch          T0:  x2               PC has addr 0 initially, gets on Bus
   //                  T1:  LD(AR)           AR loads from Bus
   //                  T2:  Read             Read MEM[AR]
   //                  T3:  x7               MEM[AR] gets on Bus
   //                  T4:  INR(PC), LD(IR)  PC incr, IR loads from Bus
   //   Decode         T5:  x5               IR gets on Bus
   //                  T6:  LD(AR), LD(I)    AR loads from Bus, I loads from Bus
   //   Indirect   D'7IT7:  Read             Read MEM[AR]
   //              D'7IT8:  x7               MEM[AR] gets on Bus
   //              D'7IT9:  LD(AR)           AR loads from Bus
   //   Repeat        T10:  CLR(SC)          re-start from T0
   ...
endmodule

module SequencerMod(clk, T, clrSC); // unary sequencer
   ...
   initial T = 16'b0000_0000_0000_0001; // T initially
   always @(posedge clrSC) T = 16'b0000_0000_0000_0001; // T cleared
   ...
endmodule

module DecoderMod(B, D); // B binary decoded into D unary
   input [2:0] B;
   output [0:7] D;
   ...
endmodule

