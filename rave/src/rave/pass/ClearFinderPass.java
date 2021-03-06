package rave.pass;

import java.util.List;

import rave.common.ConstructBuilder;
import rave.common.PatternParser;
import rave.common.PatternParser.MatchResult;
import rave.construct.Clear;
import rave.nodes.INode;

public class ClearFinderPass implements IPass {

	private PatternParser pattern = new PatternParser("[V]");
	
	@Override
	public int match(List<INode> input) {
		MatchResult result = pattern.tryMatch(input);
		return result.hasAny && input.get(1).getCoefficient() == 1 ? 3 : 0;
	}

	@Override
	public INode build(List<INode> input) {
		return new ConstructBuilder().type(Clear.class).coefficient(1).build();
	}

}
