loadfile = LOAD '$file' using PigStorage() as line:chararray ; 
token = foreach loadfile generate flatten(TOKENIZE(line)) as words:chararray;
wordgrp = GROUP token by words; 
countwords = foreach wordgrp generate group, COUNT(token);
store countwords into '$outfile';
