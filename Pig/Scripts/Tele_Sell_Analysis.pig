television = LOAD '/INPUT/DATA/television.txt' using PigStorage('|') as (tvname:chararray,tvbrand:chararray,size:int,state:chararray,pincode:chararray,price:int) ; 
filtv = FILTER television BY NOT tvname IN ('NA');
filbrand = FILTER filtv BY NOT tvbrand IN ('NA'); 
selcol = FOREACH filbrand GENERATE tvname,tvbrand;
sortcol = ORDER selcol by tvname ASC;
colgrp = GROUP sortcol BY tvname; 
tvcount = FOREACH colgrp GENERATE group, COUNT(sortcol);
store tvcount into '/OUTPUT/result';




