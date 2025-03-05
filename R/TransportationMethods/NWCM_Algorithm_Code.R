#Function for North West Corner Method
north_west = function(cost_matrix, supply, demand){
  cmr = nrow(cost_matrix)
  cmc = ncol(cost_matrix)
  zero_vector = c()
  for (i in 1:(cmc*cmr)) {
    zero_vector = c(zero_vector, 0)  
  }
  
  result = matrix(zero_vector, nrow = cmr, ncol =cmc, byrow = TRUE)
  
  
  if(cmc ==length(demand)
     && cmr ==length(supply) 
     && sum(supply)==sum(demand)){
    
    i = 1
    j = 1
    while( sum(supply)+sum(demand) != 0){
      
      if(supply[i] > demand[j]){
        result[i, j] = demand[j]
        supply[i] = supply[i] - demand[j]
        demand[j] = 0
        j = j + 1
      }else if(supply[i] < demand[j]){
        result[i, j] = supply[i]
        demand[j] = demand[j] - supply[i]
        supply[i] = 0
        i = i + 1
      }else{
        result[i, j] = supply[i]
        supply[i] = 0
        demand[j] = 0
        i = i + 1
        j = j + 1
      }
      
    } 
    print("Allocation")  
    print(result)
    paste("Z = " , sum(result*cost_matrix))
  }else{
    
    print("Number of Row/Columns mismatch with Supply/Demand or Total Value Mismatch.")
    
  }
  
}


#Calling Functions
cost_matrix = matrix(c(5, 3, 6, 2, 4, 7, 9, 1, 3, 4, 7, 5), nrow = 3, byrow = TRUE)
supply = c(19 ,37 , 34)
demand = c(16 ,18 , 31, 25)
north_west(cost_matrix, supply, demand)


cost_matrix = matrix(c(20 , 22, 17, 4, 24, 37, 9, 7, 32, 37, 20, 15), nrow = 3, byrow = TRUE)
supply = c(120, 70, 50)
demand = c(60, 40, 30, 110)
north_west(cost_matrix, supply, demand)
