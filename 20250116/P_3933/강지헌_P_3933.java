import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,e,t;
        while(true){
            t=0;
            n=sc.nextInt();
            if(n==0) return;
            e=(int)Math.sqrt(n);
            for(int i=1;i<=e;++i) {
                if(i*i==n) {
                	++t;
                    break;
                }
                for(int j=i;j<=e;++j) {
                    if(i*i+j*j==n) {
                        ++t;
                        break;
                    }
                    else if(i*i+j*j>n) break;
                    for(int k=j;k<=e;++k) {
                        if(i*i+j*j+k*k==n) {
                            ++t;
                            break;
                        }
                        else if(i*i+j*j+k*k>n) break;
                        for(int l=k;l<=e;++l) {
                            if(i*i+j*j+k*k+l*l==n) {
                                ++t;
                                break;
                            }
                            else if(i*i+j*j+k*k+l*l>n) break;
                        }
                    }
                }
            }
            System.out.println(t);
        }
    }
}
