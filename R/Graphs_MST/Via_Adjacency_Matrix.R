#Remember to download igraph package
library(igraph)

# Defining the adjacency matrix
adj_mat = matrix(c(
  0, 150, 50, 300, 50, 
  150, 0, 130, 700, 50,
  50, 130, 0, 300, 60,
  300, 700, 300, 0, 305,
  50, 50, 60, 305, 0
), nrow = 5, byrow = TRUE)

#Making graph
graph = graph_from_adjacency_matrix(adj_mat,
        mode = "undirected", weighted = TRUE)

#Setting city names as Label
V(graph)$name = c("Mumbai", "Pune", "Thane", "Nagpur", "Panvel")

# Plotting Graph
plot(graph, edge.label = E(graph)$label, vertex.color = "pink", 
     vertex.size = 30, main="Graph")

# Set edge labels as weights
E(graph)$label = E(graph)$weight

#Making Minimum Spanning Tree using Prim's algorithm
graph_mst = mst(graph, algorithm = "prim")

# Plotting Minimum Spanning Tree
plot(graph_mst, edge.label = E(graph_mst)$weight, vertex.color = "lightgreen", 
     vertex.size = 30, main="Minimum Spanning Tree")
