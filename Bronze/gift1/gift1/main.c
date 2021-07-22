/*
ID: 77617781
LANG: C
TASK: gift1
*/

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    FILE* in = fopen("gift1.in", "r");
    FILE* out = fopen("gift1.out", "w");
    int i = 0, j = 0, k = 0;
    
    int numOFfriends = 0;
    fscanf(in, "%d", &numOFfriends);//get the number of friends
    
    int balance[numOFfriends];
    for (i=0; i<numOFfriends; i++) {
        balance[i]=0;//set everything to 0
    }
    char name[numOFfriends][15];
    for (i=0; i<numOFfriends; i++) {//get the names
        fscanf(in, "%s", name[i]);
    }
    
    char tempname[15];
    int amountgiven;
    int numOFreceivers;
    char receivers[numOFfriends][15];
    
    for (i=0; i<numOFfriends; i++) {//loop friends
        fscanf(in, "%s %d %d", tempname, &amountgiven, &numOFreceivers);
        if (amountgiven==0 || numOFreceivers==0) {
            continue;
        }
        
        for (j=0; j<numOFreceivers; j++) {//get receiver names
            fscanf(in, "%s", receivers[j]);
            for (k=0; k<numOFfriends; k++) {//search for names
                if (strcmp(receivers[j], name[k])==0) {//if the name matches
                    balance[k]+=amountgiven/numOFreceivers;//add money
                }
            }
        }
        for (j=0; j<numOFfriends; j++) {//search for the giver
            if (strcmp(tempname, name[j])==0) {
                balance[j]-=amountgiven;//subtract money
                balance[j]+=amountgiven % numOFreceivers;//add ramainder
                
            }
        }
    }
    
    for (i=0; i<numOFfriends; i++) {
        fprintf(out, "%s %d\n", name[i], balance[i]);
    }
    
    fclose(in);
    fclose(out);
    return 0;
}
