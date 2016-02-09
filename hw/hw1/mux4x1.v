//mux4x1.v, 4x1 mulitplexor, gate synthesis
//Varun Ved

module MuxMod(s0, s1, d0, d1, d2, d3,o);
    //io
    input s0, s1, d0, d1, d2, d3;
    output o;

    //wires
    wire s0_inv,s1_inv,and0,and1,and2,and3;
    
    //build gates
    not(s0_inv,s0);
    not(s1_inv,s1);
    and(and0,d0,s0_inv,s1_inv);
    and(and1,d1,s0,s1_inv);
    and(and2,d2,s0_inv,s1);
    and(and3,d3,s0,s1);

    or(o,d0,d1,d2,d3);
endmodule

module TestMod;
    
    //declare
    reg s0,s1,d0,d1,d2,d3;
    wire o;

    initial begin
        $display("Time\ts0\ts1\td0\td1\td2\td3\to");
        $display("--------------------------------");
        $monitor("%0d\t%b\t%b\t%b\t%b\t%b\t%b\t%b", $time, s0,s1, d0, d1,d2,d3, o);
    end

    initial begin

    end

endmodule
