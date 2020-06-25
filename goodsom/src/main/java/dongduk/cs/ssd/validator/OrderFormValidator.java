package dongduk.cs.ssd.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import dongduk.cs.ssd.controller.order.OrderForm;

public class OrderFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderForm regReq = (OrderForm) target;


		// 필수 입력 항목
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.cardBank", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.cardNo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.validDate", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.cvc", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.address1", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.address2", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.address3", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.phone", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.refundBank", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.refundAccount", "required");

		
//		String zipcode = regReq.getAddress().getZipcode();
//		if (!zipcode.matches("^\\d{5}$")) { // zipcode가 5자리 숫자인지 검증
//			errors.pushNestedPath("address");
//			try {
//				errors.rejectValue("zipcode", "typeMismatch");
//			} finally {
//				errors.popNestedPath();
//			}
//		}
		
		String phone = regReq.getOrder().getPhone();
		if (!phone.equals("") && !phone.matches("^[0][1]\\d{1}-\\d{3,4}-\\d{4}$")) {
			errors.rejectValue("order.phone", "typeMismatch"); // 01x-xxx-xxxx or 01x-xxxx-xxxx인지 검증
		}
	}

}
