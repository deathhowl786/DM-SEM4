#Credits to shrilll & dhokla !!
#Remember to download e1071 package

library(e1071)
?naiveBayes #shows function documentation

data = iris     # built in dataset
summary(data)


#making model
model = naiveBayes(data$Species~., data) # data$Species is dependent col
#  all columns except Species
# The Notation Species~. means Species is the dependent variable, 
#  and all other columns are independent.


#test_data
test_data = data[1:2,]
test_data = test_data[, -5]


#predicting species of test_data using model
predict(model,test_data)
