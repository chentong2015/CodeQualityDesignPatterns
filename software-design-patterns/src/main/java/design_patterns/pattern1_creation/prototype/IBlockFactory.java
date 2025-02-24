package design_patterns.pattern1_creation.prototype;

import design_patterns.pattern1_creation.prototype.types.IBlock;

public interface IBlockFactory {

    IBlock createBlock(String content);
}
