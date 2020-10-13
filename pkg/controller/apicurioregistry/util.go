package apicurioregistry

import (
	"github.com/go-logr/logr"
)

func fatal(log logr.Logger, err error, msg string) {
	log.Error(err, msg)
	panic("Fatal error, the operator can't recover.")
}

func findString(haystack []string, needle string) (int, bool) {
	for i, v := range haystack {
		if needle == v {
			return i, true
		}
	}
	return -1, false
}

func findStringKey(haystack map[string]bool, needle string) bool {
	for k, _ := range haystack {
		if needle == k {
			return true
		}
	}
	return false
}

func RemoveElement(slice []interface{}, index int) {
	slice[index] = slice[len(slice)-1] // Copy last element to index i.
	slice[len(slice)-1] = ""   // Erase last element (write zero value).
	slice = slice[:len(slice)-1]
}
