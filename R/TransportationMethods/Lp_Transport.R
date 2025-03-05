#Remember to download lpSolve Package
library(lpSolve)

#lp.transport() uses MODI method to get optimal solution
# here con is constraint matrix
# rhs is demand and lhs is supply
      

#con = matrix(c(20,22, 17, 4, 24, 37, 9, 7, 32, 37, 20, 15), nrow= 3, byrow = TRUE)
#rhs = c(120, 70, 50)
#r_signs = c("=", "=", "=")
#lhs = c(60, 40, 30, 110)
#l_signs = c("=", "=", "=" , "=")
#solution = lp.transport(con, "min", r_signs, rhs, l_signs, lhs)
#solution$solution
#solution$objval

#con = matrix(c(20, 25, 28, 31, 32, 28, 32, 41, 18, 35, 24, 32, 0, 0, 0, 0), nrow= 4, byrow = TRUE)
#rhs = c(200, 180, 110, 50)
#r_signs = c("=", "=", "=", "=")
#lhs = c(150, 40, 180, 170)
#l_signs = c("=", "=", "=" , "=")
#solution = lp.transport(con, "min", r_signs, rhs, l_signs, lhs)
#solution$solution
#solution$objval

con = matrix(c(20, 28, 32, 55, 70, 48, 36, 40, 44, 25, 35, 55, 22, 45, 48), nrow= 3, byrow = TRUE)
rhs = c(50, 100 ,150)
r_signs = c("=", "=", "=")
lhs = c(100, 70, 50, 40, 40)
l_signs = c("=", "=", "=" , "=", "=")
solution = lp.transport(con, "min", r_signs, rhs, l_signs, lhs)
solution$solution
solution$objval
