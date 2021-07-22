/*
ID: 77617781
LANG: C
PROG: ride
*/

#include <stdio.h>
#include <ctype.h>

int main() {
    FILE* fPin=fopen("ride.in", "r");
    FILE* fPout=fopen("ride.out", "w");
    char str1[8];
    char str2[8];
    int count1 = 1;
    int count2 = 1;
    int i = 0;
    
    while (1) {
        fscanf(fPin, "%c", &str1[i]);
        if (str1[i]=='\n') {
            break;
        }else if(isupper(str1[i])){
            count1*=str1[i]-64;
        }
        i++;
    }
    i = 0;
    while (1) {
        fscanf(fPin, "%c", &str2[i]);
        if (feof(fPin)) {
            break;
        }else if(isupper(str2[i])){
            count2*=str2[i]-64;
        }
        i++;
    }
    if ((count1%47)==(count2%47)) {
        fprintf(fPout, "GO\n");
    }else{
        fprintf(fPout, "STAY\n");
    }
    
    fclose(fPin);
    fclose(fPout);
    return 0;
}
