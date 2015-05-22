// In Java
public static boolean isPal(int orig)
{
int copy = orig;
int reversed = 0;

while(copy!=0)
{
reversed <<= 1;
reversed |= (copy & 1);
copy >>>= 1;
}
return (reversed == orig);
}
