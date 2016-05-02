//Varun Ved

module Test();
   wire clk;
   wire [3:0] addr_count;
   wire [15:0] out_data;

   ClockMod my_clock(clk);

// program counter (PCmod)
   CountingMod my_counting(clk, addr_count);

// memory (MEMmod)
   StorageMod my_storage(addr_count, clk, 1, out_data); // read signal = 1

   initial begin
      $display("time\tclk\taddr\tdata  (hex optional)");
      $monitor("%4d\t%b\t%b\t%b (%x) ", $time, clk, addr_count, out_data,out_data);

      #32 $finish;
   end
endmodule

module ClockMod(clk);  // actually hardware: crystal oscillator
   output clk;
   reg clk;

   always begin
      clk = 0;         // falling edge (negedge)
      #1;
      clk = 1;         // rising edge (posedge)
      #1;
   end
endmodule

module CountingMod(clk, count);  // expand to PCmod
   input clk;
   output [3:0] count;

   wire [0:15] unary_pattern;

   RippleMod my_ripple(clk, unary_pattern); // generates unary pattern
   CodeMod my_coder(unary_pattern, count);  // code into binary pattern
endmodule

module StorageMod(addr, clk, read, out_stuff); // expand to MEMmod
   input [3:0] addr;
   input clk, read;
   output [15:0] out_stuff;

   reg [15:0] out_stuff;       // output buffer

   reg [15:0] stuff [0:15];     // internal storage

   wire inv_clk, read_now;
   not(inv_clk, clk);
   and(read_now, inv_clk, read);  // when read is 1 and clk falls

   always @(posedge read_now)     // read but at clk v
      out_stuff = stuff[addr];    // put out stuff

// read file instead of assigments, use "instructions.txt"
   initial $readmemb("instructions.txt", stuff);

endmodule

module CodeMod(unary_pattern, count); // unary-to-binary encoder
	input [0:15] unary_pattern;
	output [0:3] count;

	//or(C0, Q1,Q3);
	//or(C1,Q2,Q3);

	or(count[3], unary_pattern[1], unary_pattern[3], unary_pattern[5], unary_pattern[7], unary_pattern[9], unary_pattern[11], unary_pattern[13], unary_pattern[15]);
	or(count[2], unary_pattern[2], unary_pattern[3], unary_pattern[6], unary_pattern[7], unary_pattern[10], unary_pattern[11], unary_pattern[14], unary_pattern[15]);
	or(count[1], unary_pattern[4], unary_pattern[5], unary_pattern[6], unary_pattern[7], unary_pattern[12], unary_pattern[13], unary_pattern[14], unary_pattern[15]);
	or(count[0], unary_pattern[8], unary_pattern[9], unary_pattern[10], unary_pattern[11], unary_pattern[12], unary_pattern[13], unary_pattern[14], unary_pattern[15]);
	endmodule

module RippleMod(clk, unary_pattern); // unary pattern generator
   input clk;
	output [0:15] unary_pattern;
	reg [0:15] unary_pattern;

	always @(posedge clk) begin
	unary_pattern[0] <= unary_pattern[15];
	unary_pattern[1] <= unary_pattern[0];
	unary_pattern[2] <= unary_pattern[1];
	unary_pattern[3] <= unary_pattern[2];
	unary_pattern[4] <= unary_pattern[3];
	unary_pattern[5] <= unary_pattern[4];
	unary_pattern[6] <= unary_pattern[5];
	unary_pattern[7] <= unary_pattern[6];
	unary_pattern[8] <= unary_pattern[7];
	unary_pattern[9] <= unary_pattern[8];
	unary_pattern[10] <= unary_pattern[9];
	unary_pattern[11] <= unary_pattern[10];
	unary_pattern[12] <= unary_pattern[11];
	unary_pattern[13] <= unary_pattern[12];
	unary_pattern[14] <= unary_pattern[13];
	unary_pattern[15] <= unary_pattern[14];
	end
	initial unary_pattern = 16'b0000000000000001;
	
endmodule

