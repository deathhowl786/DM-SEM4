#dbinom(), dpois(), dnom() are used only for a single case ex. P(X = 10)
#pbinom(), ppois(), pnom() are used for cases having a range ex. P(10 < X < 20)

#Binomial Distribution
#Q. Defective Transistors Question done in class 
dbinom(10, 10, 0.2) #P(X=10)
dbinom(0, 10, 0.2) #P(X=0)
1-dbinom(0, 10, 0.2) #P(X>=10)
pbinom(3, 10, 0.2)-dbinom(0, 10, 0.2) #P(1>X<=3)

data = data.frame(labels = c(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 
           values= c(dbinom(0, 10, 0.2),
                     dbinom(1, 10, 0.2),
                     dbinom(2, 10, 0.2),
                     dbinom(3, 10, 0.2),
                     dbinom(4, 10, 0.2),
                     dbinom(5, 10, 0.2),
                     dbinom(6, 10, 0.2),
                     dbinom(7, 10, 0.2),
                     dbinom(8, 10, 0.2),
                     dbinom(9, 10, 0.2),
                     dbinom(10, 10, 0.2)))
ggplot(data=data, aes(x=labels, y=values, group=1))+geom_point()+theme_dark()+labs(x = "X Values", y = "Probability", title="Binomial Distribution")


#Poisson Distribution
#Q. p = 1/1000, 
#   q = 999/1000 
#   n = 2000 
#   m = n*p = 2

dpois(3, 2) # X = 3, m = 2
ppois(2000, 2) - ppois(2, 2) # X > 2, m =2


#Normal Distribution
#Q. mean = 45 & SD = 10
pnorm(40, 45, 10) # X < 40
pnorm(1000, 45, 10) - pnorm(60, 45, 10) # X > 60
pnorm(50, 45, 10) - pnorm(40, 45, 10) # 40 < X < 50




#Theory
#only one case
dbinom(1, 5, 0.25) #only prob for x=1
#all cases
pbinom(3, 5, 0.25) #prob for x<=3

#Plotting the distribution one case at a time
data = data.frame(labels = c(0, 1, 2, 3, 4, 5), 
                  values= c(dbinom(0, 5, 0.25),
                            dbinom(1, 5, 0.25),
                            dbinom(2, 5, 0.25),
                            dbinom(3, 5, 0.25),
                            dbinom(4, 5, 0.25),
                            dbinom(4, 5, 0.25)))

#library(ggplot2)
ggplot(data=data, aes(x=labels, y=values, group=1))+geom_point()+theme_dark()+labs(x = "X Values", y = "Probability", title="Binomial Distribution")


# Poisson Distribution
dpois(3, 2)

#Normal Distribution
pnorm(40,45, 10)
