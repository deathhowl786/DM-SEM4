#Remember to download igraph package
library(igraph)

#Defining edges & their weights
# A B is one edge hence total edges is 6 here
# remember number of weights and edges should be same

edges = c('A','B', 'A','C', 'A','D', 'B','C', 'C','E', 'D','E')
weight = c(3, 4, 5, 6, 7, 8)
graph = graph(edges, directed = FALSE) # Making the graph

# Assign weights and labels
E(graph)$weight = weight
E(graph)$label = weight

#Plotting Graph
plot(graph, edge.label = E(graph)$weight, vertex.color = "red", 
     vertex.size = 30, main="Graph")


#Make MST using Prim's Algorithm
mst_graph = mst(graph, algorithm = 'prim')

#Plotting MST
plot(mst_graph, edge.label = E(mst_graph)$weight, 
     vertex.color = "lightblue", 
     vertex.size = 30, main="Minimum Spanning Tree")


