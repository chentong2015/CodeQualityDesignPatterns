package creation_pattern.prototype;

import creation_pattern.prototype.types.ContentBlock;
import creation_pattern.prototype.types.NumberBlock;
import creation_pattern.prototype.types.DataTimeBlock;
import creation_pattern.prototype.types.IBlock;

import java.time.LocalDateTime;

public class IBlockFactoryImpl implements IBlockFactory {

    @Override
    public IBlock createBlock(String content) {
        if (content.contains("/") || content.contains("-")) {
            // 需要格式化读取的日期字符串
            return new DataTimeBlock(LocalDateTime.parse(content));
        } else if (isNumber(content)) {
            return new NumberBlock(Integer.parseInt(content));
        } else {
            return new ContentBlock(content);
        }
    }

    private boolean isNumber(String content) {
        try {
            Integer.parseInt(content);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
