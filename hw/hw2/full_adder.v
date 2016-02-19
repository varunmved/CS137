module FullAdderMod(x,y,c_in,sum,c_out);
    //code for full adder
    input x,y,c_in;
    output sum, c_out;

    reg xor0,xor1,and0,and1,or0;

    xor(xor0,x,y);
    and(and0,x,y);
    //xor(xor1,xor0,c_in);
    xor(sum,xor0,c_in);
    and(and1,c_in,xor0);
    //or(or0,and0,and1);
    or(c_out,and0,and1);
end module

module testMod();


end module
