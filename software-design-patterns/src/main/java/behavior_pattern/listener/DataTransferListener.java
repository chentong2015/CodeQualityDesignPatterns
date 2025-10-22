package behavior_pattern.listener;

// Listener数据监听器: 检测在数据传递过程中每个动作，并执行相应的逻辑
public class DataTransferListener {

    private final boolean showLog;

    public DataTransferListener(boolean showLog) {
        this.showLog = showLog;
    }

    public void onProcessing() {
        // notice data
    }

    public void onDataTruncation() {
        // write to output file
    }

    public void onError() {
        // ReportHelper.addNewFailedTable(error);
        // ReportHelper.addError(error.toString());
    }
}
