// 64050001 นางสาวกชนิกา แย้มศรวล
#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>

int csum, msum;
void *runner(void *param);

int main(int argc, char *argv[]){
    pthread_t tid;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_create(&tid, &attr, runner, argv[1]);
    
    int num = atoi(argv[1]);
    if(num > 0){
        for(int i = 0; i <= num; i++){
            msum += i;
        }
    }
    pthread_join(tid, NULL);

    printf("I'm parent,difference of csum and msum is %d\n",csum - msum);
    return 0;
}

void *runner(void *param){
    int num = atoi(param);
    if(num > 0){
        for(int i = 0; i <= 2*num; i++){
            csum += i;
        }
    }
    pthread_exit(0);
}

// q2.5 ans 2 กรณีคือ 1. แม่เสร็จก่อน คำตอบจะติดลบ 
// 2. ลูกเสร็จก่อนได้ตำตอบเหมือนตอน join ปกติ

