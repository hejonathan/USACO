//
/*
ID: 77617781
LANG: C
TASK: friday
*/

#include <stdio.h>

int monthdays(int year, int month);
int main(int argc, const char * argv[]) {
    FILE *in = fopen("friday.in", "r");
    FILE *out = fopen("friday.out", "w");
    int n;
    fscanf(in, "%d", &n);
    int i, j, k;
    int currentday = 0;
    int days[7];
    for (i=0; i<7; i++) {
        days[i] = 0;
    }
    
    
    for (i=0; i<n; i++) {//loop for year
        for (j=0; j<12; j++) {//loop for months
            for (k=0; k<monthdays(1900+i, j+1); k++, currentday++) {//loop for days
                if (currentday==7) {
                    currentday = 0;
                }
                if (k==12){
                    days[currentday]++;
                }
            }
        }
    }
    fprintf(out, "%d %d %d %d %d %d %d\n", days[5], days[6], days[0], days[1], days[2], days[3], days[4]);
    fclose(in);
    fclose(out);
    return 0;
}

int monthdays(int year, int month){
    switch (month) {
        case 1:
            return 31;
        case 2:
            if (year % 4==0) {
                if(year % 100==0 && year % 400!=0){
                    return 28;
                }else{
                    return 29;
                }
            }else{
                return 28;
            }
        case 3:
            return 31;
        case 4:
            return 30;
        case 5:
            return 31;
        case 6:
            return 30;
        case 7:
            return 31;
        case 8:
            return 31;
        case 9:
            return 30;
        case 10:
            return 31;
        case 11:
            return 30;
        case 12:
            return 31;
        default:
            printf("error: monthdays\n");
            break;
    }
    return 0;
}
