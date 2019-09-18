def precision(i):
    p=0.1
        




def division():
   dividend=float(input("Enter Dividend : "))
   divisor=float(input("Enter Divisor : "))
   i=0
   if divisor==0:
       raise Exception("Zero cannot be used as divisor");
   else:
       while divisor<=dividend:
           dividend=dividend-divisor;
           i+=1
         #precision(i)
       print("Answer =",i)
division()

