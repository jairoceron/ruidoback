"use strict";(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[5915],{95915:(v,u,e)=>{e.r(u),e.d(u,{create:()=>f,projectGeometry:()=>g});var d=e(61921),c=e(4380),o=e(22795),m=e(93112),y=e(10);function f(){return s.apply(this,arguments)}function s(){return(s=(0,d.Z)(function*(t=null,n){if(c.Z.geometryServiceUrl)return new((yield e.e(1361).then(e.bind(e,31361))).default)({url:c.Z.geometryServiceUrl});if(!t)throw new o.Z("internal:geometry-service-url-not-configured");let r;if(r="portal"in t?t.portal||m.Z.getDefault():t,yield r.load({signal:n}),r.helperServices&&r.helperServices.geometry&&r.helperServices.geometry.url)return new((yield e.e(1361).then(e.bind(e,31361))).default)({url:r.helperServices.geometry.url});throw new o.Z("internal:geometry-service-url-not-configured")})).apply(this,arguments)}function g(t,n){return i.apply(this,arguments)}function i(){return(i=(0,d.Z)(function*(t,n,r=null,h){const E=yield f(r,h),a=new y.Z;a.geometries=[t],a.outSpatialReference=n;const l=yield E.project(a,{signal:h});if(l&&Array.isArray(l)&&1===l.length)return l[0];throw new o.Z("internal:geometry-service-projection-failed")})).apply(this,arguments)}}}]);