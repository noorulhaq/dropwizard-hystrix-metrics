package io.github.noorulhaq.metrics.hystrix;

import com.codahale.metrics.MetricRegistry;
import com.netflix.hystrix.*;
import com.netflix.hystrix.contrib.codahalemetricspublisher.HystrixCodaHaleMetricsPublisherThreadPool;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherCommand;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherThreadPool;

/**
 * Created by husainbasrawala on 1/2/17.
 */
public class DropWizardMetricsPublisher extends HystrixMetricsPublisher{

    protected final MetricRegistry metricRegistry;

    public DropWizardMetricsPublisher(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

    @Override
    public HystrixMetricsPublisherCommand getMetricsPublisherForCommand(HystrixCommandKey commandKey,
                                                                        HystrixCommandGroupKey commandGroupKey,
                                                                        HystrixCommandMetrics metrics,
                                                                        HystrixCircuitBreaker circuitBreaker,
                                                                        HystrixCommandProperties properties) {
        return new DropWizardPublisherCommand(commandKey, commandGroupKey, metrics, circuitBreaker, properties, metricRegistry);
    }

    @Override
    public HystrixMetricsPublisherThreadPool getMetricsPublisherForThreadPool(HystrixThreadPoolKey threadPoolKey,
                                                                              HystrixThreadPoolMetrics metrics,
                                                                              HystrixThreadPoolProperties properties) {
        return new HystrixCodaHaleMetricsPublisherThreadPool(threadPoolKey, metrics, properties, metricRegistry);
    }

}
