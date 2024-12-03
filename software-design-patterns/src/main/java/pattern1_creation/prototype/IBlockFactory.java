package pattern1_creation.prototype;

import pattern1_creation.prototype.types.IBlock;

public interface IBlockFactory {

    IBlock createBlock(String content);
}
