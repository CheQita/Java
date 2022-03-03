
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.*;

public class RouterNode {
  private int myID;
  private GuiTextArea myGUI;
  private RouterSimulator sim;
  private int[] nbrCosts;
  private int[][] nodeDistanceVectors;
  private HashMap<Integer, Integer> paths;		//<destinationID, nextNodeID> 


  //--------------------------------------------------
  public RouterNode(int ID, RouterSimulator sim, int[] _costs) {
    myID = ID;
    this.sim = sim;
    nbrCosts = new int[sim.NUM_NODES];
    nodeDistanceVectors = new int[sim.NUM_NODES][sim.NUM_NODES];
    paths = new HashMap<>();
    

    myGUI =new GuiTextArea("  Output window for Router #"+ ID + "  ");

    System.arraycopy(_costs, 0, nbrCosts, 0, sim.NUM_NODES);
     
    // We dont know the distances yet so we set them to unreachable
    for(int[] v : nodeDistanceVectors) {
        Arrays.fill(v, sim.INFINITY);
      }
    
    for(int i = 0; i < nbrCosts.length; i++) {
        nodeDistanceVectors[myID][i] = nbrCosts[i];

        if(i != myID && nbrCosts[i] != sim.INFINITY)
          paths.put(i, i);
        //after this we only have the paths to our neighbours
      }

      // It costs zero to ourself
      nodeDistanceVectors[myID][myID] = 0;
    
    
      updateOtherNodes();
      

  }
  
 
 private void updateOtherNodes() {
	 int[] distanceVector = nodeDistanceVectors[myID].clone();
	 for(int destID : paths.keySet()) {
		 sendUpdate(new RouterPacket(myID, destID, distanceVector));
	 }
	
	 
 }

  //--------------------------------------------------
  public void recvUpdate(RouterPacket pkt) {
	  //Update my routingTable(costs) from the information recieved by neighbours.
	  myGUI.println();
	  myGUI.println("Recieved updates from node "  + pkt.sourceid);
	  myGUI.println("Updating the distanceTable");
	  nodeDistanceVectors[pkt.sourceid] = pkt.mincost.clone();
	  calculateCheapestPath();
  }

  //--------------------------------------------------
  private void sendUpdate(RouterPacket pkt) {
    sim.toLayer2(pkt);

  }

  
  private void calculateCheapestPath() {
	    boolean changes = false;

	    // Loop through our distanceVector and maybe update it
	    for (int nodeID = 0; nodeID < nodeDistanceVectors[myID].length; nodeID++) {
	      if (nodeID == myID) 
	    	  continue;

	      // Does anyone have a cheaper route to node? 
	      // Do not check my own DV and only direct neighbors
	      int cheapest = nbrCosts[nodeID];
	      int passingNode= nodeID;
	      for( int nbr = 0; nbr < nbrCosts.length; ++nbr) {			//nbr=neighbour
	        if (nbr == myID || nbrCosts[nbr] == sim.INFINITY){
	          continue;
	        }
	        int costThroughNbr = nbrCosts[nbr] + nodeDistanceVectors[nbr][nodeID];  

	        if(costThroughNbr < cheapest) {
	          cheapest = costThroughNbr;
	          passingNode = nbr;
	        }
	      }

	      // Do we have a new cheapest route to node?
	      if(cheapest != nodeDistanceVectors[myID][nodeID]) {
	        myGUI.println(String.format("Updated cost to node %s. from %s. to %s. Path through node %s\n", nodeID, nodeDistanceVectors[myID][nodeID], cheapest, passingNode));
	        nodeDistanceVectors[myID][nodeID] = cheapest;
	        paths.put(nodeID, passingNode);
	        changes = true;
	      }
	    }

	    if (changes)
	     updateOtherNodes();
	    myGUI.println("Changes has been done. Sending updates");
	  }
  
  //--------------------------------------------------
  public void printDistanceTable() {
	    myGUI.println("\n");
	    myGUI.println("Current table for " + myID + "  at time " + sim.getClocktime());
	    printNeighborDistanceTables();
	    printOurDistanceTable();
	    myGUI.println("\n");
	  }

	  private void printNeighborDistanceTables() {
	    myGUI.println("\nDistancetable:");
	    printHeader();

	    for(int nodeID = 0; nodeID < nbrCosts.length; nodeID++) {
	      if(nbrCosts[nodeID] == sim.INFINITY)				//Its not a neighbour
	    	  continue;
	      if(nodeID == myID)	  
	    	  myGUI.print(" this   " + " |");
	      else
	    	  myGUI.print(" nbr  " + nodeID + " |");

	      for(int distance : nodeDistanceVectors[nodeID]) {
	        myGUI.print(String.format("%10d", distance));
	      }
	      myGUI.println();
	    }
	  }

	  private void printOurDistanceTable() {
	    myGUI.println("Our distance vector and routes:");
	    printHeader();

	    myGUI.println();
	    myGUI.print(String.format(" %7s |", "cost"));

	    for(int cost : nbrCosts) {
	      myGUI.print(String.format("%10s", cost));
	    }
	    myGUI.println();

	    myGUI.print(String.format(" %7s |", "path"));

	    for(int nodeID = 0; nodeID < nbrCosts.length; nodeID++) {
	      String nextNode = "-";
	      if(paths.get(nodeID) != null) 
	        nextNode = Integer.toString(paths.get(nodeID));
	      myGUI.print(String.format("%10s", nextNode));
	    }
	  }

	  private void printHeader() {
	    myGUI.print("     dst |");
	    String divider = "-----";

	    for(int nodeID = 0; nodeID < sim.NUM_NODES; nodeID++) {
	      myGUI.print(String.format("%10d", nodeID));
	      divider += "------";
	    }

	    myGUI.println();
	    myGUI.println(divider);
	  }

  //--------------------------------------------------
  public void updateLinkCost(int dest, int newcost) {
	  	  myGUI.println();
		  myGUI.println("Updating cost to node " + dest + ". From: " + this.nbrCosts[dest]+ " to " + newcost);
		  myGUI.println("Looking for cheaper paths");
		  this.nbrCosts[dest] = newcost;
		  calculateCheapestPath();
	  }
	  
 }


