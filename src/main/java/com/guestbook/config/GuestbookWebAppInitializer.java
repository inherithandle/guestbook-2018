//package com.guestbook.config;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
///**
// * this class is a substitute for web.xml.
// * any class that is responsible for creating the DispatcherServlet object
// * has to extend AbstractAnnotationConfigDispatcherServletInitializer.
// */
//public class GuestbookWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    /**
//     * returned classes from by this method define data-tier components
//     * @return
//     */
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[] { RootConfig.class};
//    }
//
//
//    /**
//     * returned classes from this method define web-related beans such as controllers view resolvers
//     * , and handler mappings.
//     * @return
//     */
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[] { WebConfig.class };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
//}
