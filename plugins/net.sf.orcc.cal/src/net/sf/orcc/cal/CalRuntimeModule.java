/*
 * generated by Xtext
 */
package net.sf.orcc.cal;

/**
 * Use this class to register components to be used within the IDE.
 */
public class CalRuntimeModule extends net.sf.orcc.cal.AbstractCalRuntimeModule {

	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return CalValueConverter.class;
	}

}
