package io.nineseventwo.atlas.sample.service;

import io.nineseventwo.atlas.annotation.Atlas;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@Atlas
public class PermutationServiceImpl implements PermutationService {
	
	@Override
	public long permutate(long x, long y) {
		if (log.isDebugEnabled()) {
			log.debug("Received following parameters for permutation. x = '" + x + "', y = '" + y + "'");
		}
		
		return x + y;
	}
	
}
