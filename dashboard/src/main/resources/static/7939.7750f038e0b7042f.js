"use strict";(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[7939],{67939:(I,p,n)=>{n.r(p),n.d(p,{default:()=>D});var a=n(61921),E=n(22795),m=n(33870),h=n(60305),u=n(12523),i=n(89096),c=n(90097),P=n(32620),g=n(68310),O=n(44654),f=n(54135),M=n(99303),T=n(89756),C=n(25808);class D{constructor(){var e=this;this._queryEngine=null,this._customParameters=null,this._snapshotFeatures=function(){var r=(0,a.Z)(function*(t){const{objectIdField:_}=e._queryEngine,l=yield(0,T.Bm)(e._getFeatureUrl,e._featureType.typeName,e._getFeatureOutputFormat,{customParameters:e._customParameters,dateFields:e._queryEngine.fieldsIndex.dateFields.map(s=>s.name),signal:t});yield(0,f.O3)(l),(0,u.k_)(t);const o=(0,f.lG)(l,{geometryType:e._queryEngine.geometryType,hasZ:!1,objectIdField:_});if(!(0,i.fS)(e._queryEngine.spatialReference,i.Zn))for(const s of o)(0,h.pC)(s.geometry)&&(s.geometry=(0,c.GH)((0,g.iV)((0,c.di)(s.geometry,e._queryEngine.geometryType,!1,!1),i.Zn,e._queryEngine.spatialReference)));let y=1;for(const s of o){const d={};(0,M.O0)(e._fieldsIndex,d,s.attributes,null,!0),s.attributes=d,null==s.attributes[_]&&(s.objectId=s.attributes[_]=y++)}return o});return function(t){return r.apply(this,arguments)}}()}destroy(){var e;null==(e=this._queryEngine)||e.destroy(),this._queryEngine=null}load(e,r){var t=this;return(0,a.Z)(function*(){const{getFeatureUrl:_,getFeatureOutputFormat:l,spatialReference:o,fields:y,geometryType:s,featureType:d,objectIdField:F,customParameters:v}=e;t._featureType=d,t._customParameters=v,t._getFeatureUrl=_,t._getFeatureOutputFormat=l,t._fieldsIndex=new C.Z(y),yield t._checkProjection(o),(0,u.k_)(r),t._queryEngine=new O.Z({fields:y,geometryType:s,hasM:!1,hasZ:!1,objectIdField:F,spatialReference:o,timeInfo:null,featureStore:new P.Z({geometryType:s,hasM:!1,hasZ:!1})});const j=yield t._snapshotFeatures((0,h.Wg)(r.signal));return t._queryEngine.featureStore.addMany(j),{extent:t._queryEngine.fullExtent}})()}applyEdits(){return(0,a.Z)(function*(){throw new E.Z("wfs-source:editing-not-supported","applyEdits() is not supported on WFSLayer")})()}queryFeatures(e={},r={}){var t=this;return(0,a.Z)(function*(){return yield t._waitSnapshotComplete(),t._queryEngine.executeQuery(e,r.signal)})()}queryFeatureCount(e={},r={}){var t=this;return(0,a.Z)(function*(){return yield t._waitSnapshotComplete(),t._queryEngine.executeQueryForCount(e,r.signal)})()}queryObjectIds(e={},r={}){var t=this;return(0,a.Z)(function*(){return yield t._waitSnapshotComplete(),t._queryEngine.executeQueryForIds(e,r.signal)})()}queryExtent(e={},r={}){var t=this;return(0,a.Z)(function*(){return yield t._waitSnapshotComplete(),t._queryEngine.executeQueryForExtent(e,r.signal)})()}querySnapping(e,r={}){var t=this;return(0,a.Z)(function*(){return yield t._waitSnapshotComplete(),t._queryEngine.executeQueryForSnapping(e,r.signal)})()}setCustomParameters(e){this._customParameters=e}refresh(){var e=this;return(0,a.Z)(function*(){var r;return null==(r=e._snapshotTask)||r.abort(),e._snapshotTask=(0,u.vr)(e._snapshotFeatures),e._snapshotTask.promise.then(t=>{e._queryEngine.featureStore.clear(),t&&e._queryEngine.featureStore.addMany(t)},t=>{e._queryEngine.featureStore.clear(),(0,u.D_)(t)||m.Z.getLogger("esri.layers.WFSLayer").error(new E.Z("wfs-layer:getfeature-error","An error occurred during the GetFeature request",{error:t}))}),yield e._waitSnapshotComplete(),{extent:e._queryEngine.fullExtent}})()}_waitSnapshotComplete(){var e=this;return(0,a.Z)(function*(){if(e._snapshotTask&&!e._snapshotTask.finished){try{yield e._snapshotTask.promise}catch(r){}return e._waitSnapshotComplete()}})()}_checkProjection(e){return(0,a.Z)(function*(){try{yield(0,g._W)(i.Zn,e)}catch(r){throw new E.Z("unsupported-projection","Projection not supported",{spatialReference:e})}})()}}}}]);