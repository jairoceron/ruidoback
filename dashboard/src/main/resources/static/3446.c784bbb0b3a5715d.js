"use strict";(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[3446],{93446:(Z,P,a)=>{a.r(P),a.d(P,{addOrUpdateResource:()=>I,contentToBlob:()=>O,fetchResources:()=>U,getSiblingOfSameType:()=>T,getSiblingOfSameTypeI:()=>A,removeAllResources:()=>D,removeResource:()=>b,splitPrefixFileNameAndExtension:()=>f});var i=a(61921),R=a(40662),E=a(22795),l=a(60305),o=a(89225);function U(e){return p.apply(this,arguments)}function p(){return(p=(0,i.Z)(function*(e,t={},r){yield e.load(r);const n=(0,o.v_)(e.itemUrl,"resources"),{start:u=1,num:g=10,sortOrder:c="asc",sortField:d="created"}=t,v={query:{start:u,num:g,sortOrder:c,sortField:d,token:e.apiKey},signal:(0,l.U2)(r,"signal")},s=yield e.portal._request(n,v);return{total:s.total,nextStart:s.nextStart,resources:s.resources.map(({created:C,size:B,resource:F})=>({created:new Date(C),size:B,resource:e.resourceFromPath(F)}))}})).apply(this,arguments)}function I(e,t,r,n){return _.apply(this,arguments)}function _(){return(_=(0,i.Z)(function*(e,t,r,n){if(!e.hasPath())throw new E.Z(`portal-item-resource-${t}:invalid-path`,"Resource does not have a valid path");const u=e.portalItem;yield u.load(n);const g=(0,o.v_)(u.userItemUrl,"add"===t?"addResources":"updateResources"),[c,d]=x(e.path),v=yield O(r),s=new FormData;return c&&"."!==c&&s.append("resourcesPrefix",c),s.append("fileName",d),s.append("file",v,d),s.append("f","json"),(0,l.pC)(n)&&n.access&&s.append("access",n.access),yield u.portal._request(g,{method:"post",body:s,signal:(0,l.U2)(n,"signal")}),e})).apply(this,arguments)}function b(e,t,r){return h.apply(this,arguments)}function h(){return(h=(0,i.Z)(function*(e,t,r){if(!t.hasPath())throw new E.Z("portal-item-resources-remove:invalid-path","Resource does not have a valid path");yield e.load(r);const n=(0,o.v_)(e.userItemUrl,"removeResources");yield e.portal._request(n,{method:"post",query:{resource:t.path},signal:(0,l.U2)(r,"signal")}),t.portalItem=null})).apply(this,arguments)}function D(e,t){return m.apply(this,arguments)}function m(){return(m=(0,i.Z)(function*(e,t){yield e.load(t);const r=(0,o.v_)(e.userItemUrl,"removeResources");return e.portal._request(r,{method:"post",query:{deleteAll:!0},signal:(0,l.U2)(t,"signal")})})).apply(this,arguments)}function x(e){const t=e.lastIndexOf("/");return-1===t?[".",e]:[e.slice(0,t),e.slice(t+1)]}function f(e){const[t,r]=function(e){const t=(0,o.Ml)(e);return(0,l.Wi)(t)?[e,""]:[e.slice(0,e.length-t.length-1),`.${t}`]}(e),[n,u]=x(t);return[n,u,r]}function O(e){return y.apply(this,arguments)}function y(){return(y=(0,i.Z)(function*(e){return e instanceof Blob?e:(yield(0,R.default)(e.url,{responseType:"blob"})).data})).apply(this,arguments)}function T(e,t){if(!e.hasPath())return null;const[r,,n]=f(e.path);return e.portalItem.resourceFromPath((0,o.v_)(r,t+n))}function A(e,t){if(!e.hasPath())return null;const[r,,n]=f(e.path);return e.portalItem.resourceFromPath((0,o.v_)(r,t+n))}}}]);