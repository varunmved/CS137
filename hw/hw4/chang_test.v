module D_FF(D,Q,CLK,RST);
output Q;
input D,CLK,RST;
reg Q;
//always @ (posedge CLK or negedge RST)
if(~RST) Q=1'b0;
else Q=D;
endmodule



module Ripple_Counter(Count,RST,A0,A1,A2,A3);
output A0,A1,A2,A3;
input Count,RST;
//reg A0,A1,A2,A3;

D_FF d0(~A0,A0,Count,RST);
D_FF d1(~A1,A1,A0,RST);
D_FF d2(~A2,A2,A1,RST);
D_FF d3(~A3,A3,A2,RST);

endmodule



module Test_Ripple_Counter;
.
.
. 
endmodule
