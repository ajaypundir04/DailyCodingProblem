AR -\> 10, 15, 3, 7

I = 0

SUM = 17

 

REC(AR, I, SUM)

Step1: if I \> size of AR then return FALSE

Step2: IF SUM == AR[I] then return TRUE

Step3: IF SUM \< AR[I] then REC(AR, I + 1, SUM)

Step4: REC(AR, I + 1, SUM - AR[I]) \|\| REC(AR, I + 1, SUM)

 
