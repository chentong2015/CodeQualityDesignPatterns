package core_patterns.proxy;

// Proxy代理设计模式:
// 1. 可以用来分离业务规则和任何种类的实现问题，防止业务规则被污染
//    将应用程序业务规则和(数据库，中间件，第三方API)进行隔离，避免业务规则受到变化带来的影响
//    Application --> Proxy Layer代理层 --> API
//    把所有关于应用程序和API之间的映射关系都集中到代理中，维护可能比较难
// 2. 代理模式是一个非常重型的解决方案，一般需要满足如下使用条件
//    当代理模式所提供的应用程序和API的极端分离式有益的
//    适用于API变动非常大的系统，或者同时运行许多不同的数据库引擎，中间件引擎之上的系统
// 3. 代理运用场景:
//    TODO: 在开发过程中，很多场景的问题都可以通过添加一层(动态)代理来解决 !!
//    被代理对象通过"代理"来对真实对象进行访问，在其中可提供额外的功能操作(比如Interceptor)
public class BaseProxy {

    // Forward Proxy 正向代理使用场景: >> 客户端的代理, 客户端架设
    // 1. 突破访问限制
    // 2. 提高访问速度: 代理服务器可以将部分请求的响应缓存到缓冲区，可直接将缓存的数据做用户请求的响应返回
    // 3. 隐藏客户端真实IP

    // Reverse Proxy 反向代理使用场景: >> 服务器的代理, 服务器架设
    // 1. 隐藏服务器真实IP
    // 2. 负载均衡: 客户端请求分发到不同的真实服务器上
    // 3. 提高访问速度
    // 4. 提供安全保障: 作为应用层防火墙，避免web攻击行为，为后端提供加密
}
