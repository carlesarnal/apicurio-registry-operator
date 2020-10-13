package apicurioregistry

import (
	"github.com/Apicurio/apicurio-registry-operator/pkg/controller/apicurioregistry/loop"
	"github.com/Apicurio/apicurio-registry-operator/pkg/controller/apicurioregistry/svc"
)

var _ loop.ControlFunction = &ProfileCF{}

const ENV_QUARKUS_PROFILE = "QUARKUS_PROFILE"

type ProfileCF struct {
	ctx        loop.ControlLoopContext
	profileSet bool
}

// Is responsible for managing environment variables from the env cache
func NewProfileCF(ctx loop.ControlLoopContext) loop.ControlFunction {
	return &ProfileCF{
		ctx:        ctx,
		profileSet: false,
	}
}

func (this *ProfileCF) Describe() string {
	return "ProfileCF"
}

func (this *ProfileCF) Sense() {
	// Observation #1
	// Was the profile env var set?
	_, profileSet := this.ctx.RequireService(svc.SVC_ENV_CACHE).(EnvCache).Get(ENV_QUARKUS_PROFILE)
	this.profileSet = profileSet

}

func (this *ProfileCF) Compare() bool {
	// Condition #1
	// Env var does not exist
	return !this.profileSet
}

func (this *ProfileCF) Respond() {
	// Response #1
	// Just set the value(s)!
	this.ctx.RequireService(svc.SVC_ENV_CACHE).(EnvCache).Set(NewSimpleEnvCacheEntry(ENV_QUARKUS_PROFILE, "prod"))

}

func (this *ProfileCF) Cleanup() bool {
	// No cleanup
	return true
}
