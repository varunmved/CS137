//decoder2x4.v, 2x4 decoder
//
//Varun Ved

//module definition
module DecoderMod(s0,s1,o0,o1,o2,o3); 
    //declare input and output
    input s0;
    input s1;
    output o0,o1,o2,o3;
    
    //add wires
    //wire s1_inv,s0_inv,and0,and1,and2,and3;
    reg s1_inv,s0_inv,and0,and1,and2,and3;


    assign o0 = (~s0) && (~s1);
    assign o1 = (s0) && (~s1);
    assign o2 = (s1) && (~s0);
    assign o3 = (s1) && (s0);
    
    endmodule

module TestMod;
    //declare flip flop and wires
    reg s0,s1;
    wire o0,o1,o2,o3;

    //create instance
    DecoderMod md(s0,s1,o0,o1,o2,o3);
    
    initial begin
            $monitor("%0d\t%b\t%b\t%b\t%b\t%b\t%b", $time, s0, s1, o0, o1, o2, o3);
            $display("Time\ts0\ts1\to0\to1\to2\to3");
            $display("--------------------------");
    end

    initial begin
      s0 = 0;       // initially s is 0
      s1 = 0;       // change s to 1
      #1;          // wait 1 simulation time unit/cycle
      s0 = 0;       // change s to 0
      s1 = 1;       // change s to 1
      #1
      s0 = 1;       // change s to 0
      s1 = 0;
      #1
      s0 = 1;       // change s to 0
      s1 = 1; 
  end
   endmodule
    
