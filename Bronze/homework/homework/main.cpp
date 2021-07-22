#include <fstream>
#include <iostream>
using namespace std;
int main(int argc, const char * argv[]) {
    ifstream fin("homework.in");
    ofstream fout("homework.out");
    int n=1;
    fin>>n;
    int arr[n];
    for (int i=0; i<n; i++) {
        fin >> arr[i];
    }
    int cmin=arr[n-1];
    float mxavg=arr[n-1];
    float avg=(float)arr[n-1];
    float result[n];
    //memset(result, 0, n*sizeof(int));
    for (int i=n-1; i>=1; i--) {
        int size=n-i;
        if(arr[i]<cmin){
            avg+=(float)(cmin-avg)/size;
            cmin=arr[i];
        }else{
            avg+=(float)(arr[i]-avg)/size;
        }
        result[i]=avg;
        if(avg>mxavg){
            mxavg=avg;
        }
    }
    for(int i=1; i<n-1;i++){
        //fout<<i<<" "<<result[i]<<endl;
        if (mxavg==result[i]) {
            fout<<i<<endl;
        }
    }
    
    fin.close();
    fout.close();
    return 0;
}
