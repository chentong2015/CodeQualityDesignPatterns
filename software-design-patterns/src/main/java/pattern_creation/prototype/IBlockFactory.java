package pattern_creation.prototype;

import pattern_creation.prototype.types.IBlock;

public interface IBlockFactory {

    IBlock createBlock(String content);
}
