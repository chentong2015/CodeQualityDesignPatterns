package creation_pattern.prototype;

import creation_pattern.prototype.types.IBlock;

public interface IBlockFactory {

    IBlock createBlock(String content);
}
