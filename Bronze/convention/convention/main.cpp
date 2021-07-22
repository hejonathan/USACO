
#include <iostream>
#include <fstream>
using namespace std;


int isperfect(long t) {
        long sum=0;
        for(long i=1; i<=t/2; i++) {
            if(t%i==0) {
                sum+=i;
            }
        }
        if(sum==t) {
            return 2;
        }else if(sum>=t-2 && sum<=t+2) {
            return 1;
        }else {
            return 0;
        }
    }

void main() {
    FILE *fin = fopen(<#const char *__filename#>, <#const char *__mode#>)
        Scanner scan = new Scanner(System.in);
        //System.out.println("Enter:");
        long t = scan.nextLong();
        if(isperfect(t)==2) {
            System.out.print(t+" perfect");
        }else if(isperfect(t)==1){
            System.out.print(t+" almost perfect");
        }else {
            System.out.print(t+" not perfect");
        }
    }
