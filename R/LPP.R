#Remember to donwload this package
library(lpSolve)

#416.
#con = matrix(c(1, 2, 3, 1, 1, 0), nrow= 2, byrow = TRUE)
#z = c(1, 2, 3)
#rhs = c(10, 5)
#con_dir = c('<=', '<=')
#sol = lp("max", objective.in = z, const.mat = con, const.dir = con_dir, const.rhs = rhs)
 

#417.
#con = matrix(c(3, 1, 1, 1, -1, 2, 1, 1, -1), nrow= 3, byrow = TRUE)
#z = c(2, -1, 1)
#rhs = c(60, 10, 20)
#con_dir = c('<=', '<=', '<=')
#sol = lp("max", objective.in = z, const.mat = con, const.dir = con_dir, const.rhs = rhs)


#418.
#con = matrix(c(1, 2, 1, 3, 0, 2, 1, 0, 4), nrow= 3, byrow = TRUE)
#z = c(3, 2, 5)
#rhs = c(430, 460, 420)
#con_dir = c('<=', '<=', '<=')
#sol = lp("max", objective.in = z, const.mat = con, const.dir = con_dir, const.rhs = rhs)


#420.
#con = matrix(c(1, 2, 2, 4, 2, 0, 2, 1, 3, 3, 1, 1), nrow= 3, byrow = TRUE)
#z = c(4, 3, 4, 6)
#rhs = c(80, 60, 80)
#con_dir = c('<=', '<=', '<=')
#sol = lp("max", objective.in = z, const.mat = con, const.dir = con_dir, const.rhs = rhs)
#sol$solution
#sol$objval

#4.21
con = matrix(c(1, 1, 1, 1, 7, 5, 3, 2, 3, 5, 10, 15), nrow= 3, byrow = TRUE)
z = c(4, 5, 9, 11)
rhs = c(15, 120, 100)
con_dir = c('<=', '<=', '<=')
sol = lp("max", objective.in = z, const.mat = con, const.dir = con_dir, const.rhs = rhs)
sol$solution
sol$objval
