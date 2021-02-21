/**
 * 
 */
 
 var hammingWeight = function(n) {
 
 	var i=0;
 	var count=0;
    while(i<n.length){
      
      if(n[i] == 1){
      	count++;
      }
      i++;
    }
    
    console.log("test : " + count);
    
};

var n = 00000000000000000000000000001011;
hammingWeight(n);