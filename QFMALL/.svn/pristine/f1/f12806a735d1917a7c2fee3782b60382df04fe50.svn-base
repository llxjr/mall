package cn.funwx.mall.exception;
import org.apache.commons.lang.exception.ExceptionUtils;

public class BusinessException extends RuntimeException
{
  private static final long serialVersionUID = -8138602623241348983L;
  private String errorCode = "UNKNOW_ERROR";

  protected String[] errorArgs = null;

  private String errorMessage = null;

  public BusinessException()
  {
  }

  public BusinessException(Throwable e)
  {
    super(e);
    this.errorMessage = ExceptionUtils.getStackTrace(e);
  }

  public BusinessException(String errorCode, String[] errorArgs) {
    super(errorCode);
    this.errorCode = errorCode;
    this.errorArgs = errorArgs;
  }

  public BusinessException(String errorCode, String errorMessage) {
    super(errorCode);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public BusinessException(String errorCode, String errorMessage, String[] errorArgs) {
    super(errorCode);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.errorArgs = errorArgs;
  }

  public BusinessException(String errorCode, String[] errorArgs, Throwable cause) {
    super(cause);
    this.errorCode = errorCode;
    this.errorArgs = errorArgs;
  }

  public BusinessException(String errorCode, String errorArg, Throwable cause) {
    super(cause);
    this.errorCode = errorCode;
    this.errorArgs = new String[] { errorArg };
  }

  public BusinessException(String errorMessage) {
    super(errorMessage);
    this.errorMessage = errorMessage;
  }

  public String getMessage()
  {
    if (this.errorMessage != null) {
      return this.errorMessage;
    }
    if (super.getMessage() != null)
      return super.getMessage();
    return this.errorMessage;
  }

  public String getMessageDetail()
  {
    return this.errorMessage;
  }

  public String getErrorCode() {
    return this.errorCode;
  }
}
